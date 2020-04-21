
var admin = require("firebase-admin");
const fs = require('fs');
const csv = require('fast-csv');
const generator = require('generate-password');
const argParser = new require('argparse').ArgumentParser();

argParser.addArgument(['-c', '--firebase-config-file'], { required: true });
argParser.addArgument(['-i', '--user-info-file'], { required: false });
argParser.addArgument(['-o', '--creds-output-file'], { required: false });
argParser.addArgument(['-a', '--action'], {required: true});

let args, firebaseAuth;

async function writeToCSV(data) {
    if(data && data.length > 0) {
        let ws = fs.createWriteStream(args['creds_output_file']);
        csv.write(data, { headers: true })
        .pipe(ws);
    }
}

async function generateFirebaseCreds(emailId, password) {
    if(!firebaseAuth) {
        console.error(`firebase auth object doesn't exist.`)
    }
    return firebaseAuth.createUser({
        email: emailId,
        emailVerified: false,
        password: password,
        disabled: false
    });
}

async function updateFirebaseCreds(uid, emailId, password) {
    if(!firebaseAuth) {
        console.error(`firebase auth object doesn't exist.`)
    }
    return firebaseAuth.updateUser(uid, {
        email: emailId,
        emailVerified: false,
        password: password,
        disabled: false
    });
}

async function deleteFirebaseCreds(uid) {
    if(!firebaseAuth) {
        console.error(`firebase auth object doesn't exist.`)
    }
    return firebaseAuth.deleteUser(uid); 
}

async function deleteFirebaseCredsForUids(uids) {
    if(!uids || uids.length === 0) {
        console.error(`uid list is empty or null`);
    }
    for(let uid of uids) {
        try {
            await deleteFirebaseCreds(uid.uid);
        } catch (err) {
            console.error(`Error occured while deleting user with uid: ${uid.uid}`);
        }
    }
}

async function listFirebaseUsers(data,nextPageToken) {
    // List batch of users, 1000 at a time.
  await  firebaseAuth.listUsers(1000, nextPageToken)
      .then(function(listUsersResult) {
        listUsersResult.users.forEach(function(userRecord) {
          data.push({email: userRecord.email, uid: userRecord.uid});
          console.log(`"${userRecord.email}","${userRecord.uid}"`) ;
        });
        if (listUsersResult.pageToken) {
          // List next batch of users.
          listAllUsers(data, listUsersResult.pageToken);
        }
      })
      .catch(function(error) {
        console.log('Error listing users:', error);
      });
}

async function createOrUpdateFirebaseCredsForEmails(emailObjList, update=false) {
    if(!emailObjList || emailObjList.length === 0) {
        console.error(`Email object list is empty or null`);
    }
    let creds = [];
    for(let emailObj of emailObjList) {
        let password = generator.generate({
            length: 12,
            strict: true
        });
        let userRecord;
        try {
            if(update) {
                userRecord = await updateFirebaseCreds(emailObj.uid, emailObj.email, password);
            } else {
                userRecord = await generateFirebaseCreds(emailObj.email, password);
            }
        } catch(err) {
            console.error(`Error occured while generating/updating firebase creds for user, ${err}`);
        }
        if(userRecord) {
            creds.push({email: userRecord.email, password: password, uid: userRecord.uid});
        }    
    }
    return creds;
}

async function run() {
    args = argParser.parseArgs();
    console.log(JSON.stringify(args));
    let app = admin.initializeApp({
        credential: admin.credential.cert(args['firebase_config_file']),
    });
    firebaseAuth = app.auth();
    if(args.action === 'list') {
        let userData=[];
        await listFirebaseUsers(userData);
        writeToCSV(userData);
    } else {
        if(!args.user_info_file) {
            console.error(`action requires --user-info-file`);
            exit(1);
        }
        let usersData = [];
        csv.parseFile(args['user_info_file'], {headers: true})
        .on('data', (row) => {
            console.log(`row: ${JSON.stringify(row)}`);
            usersData.push(row);
        })
        .on('end', (rowCount) => {
            console.log(`Parsed ${rowCount} rows`);
            if(args.action === 'create' || args.action === 'update') {
                createOrUpdateFirebaseCredsForEmails(usersData, args.action === 'update').then(writeToCSV);
            } else if(args.action === 'delete') {
                deleteFirebaseCredsForUids(usersData);
            } else {
                console.error(`Unknown action.`)
                exit(1);
            }
        });
    }
}

run().catch(err => {
    console.error(err.stack);
    process.exit(1);
});


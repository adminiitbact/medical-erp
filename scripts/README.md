## Helper scripts

Install required packages

```
$ npm i fast-csv generate-password argparse firebase-admin
```

### To create firebase  credentials for users.

```
$ node firebase-admin-utils.js -c <path-to-firebase-admin-credentials> -i <input-file-containing-user-emails> -o <filename-to-write-generated-creds> -a create
```

#### Sample Input file (containing user emails)

```
$ cat input.csv
email
user1@domain.com
user2@domain.com
user3@domain.com
```

#### Sample firebase credentials file

```
$ cat firebase-config.json

  "type": "service_account",
  "project_id": "<project_id>",
  "private_key_id": "<private_key_id>",
  "private_key": "<private_key>",
  "client_email": "<client_email>",
  "client_id": "<client_id>",
  "auth_uri": "<auth_uri>",
  "token_uri": "<token_uri>",
  "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
  "client_x509_cert_url": "<client_x509_cert_url>"
}

```

### To update firebase credentials for users.

```
$ node firebase-admin-utils.js -c <path-to-firebase-admin-credentials> -i <input-file-containing-user-email and uid> -o <filename-to-write-updated-creds> -a update
```

#### Sample Input file (containing email and uid of users need to be updated)

```
$ cat input.csv
email,uid
user1@domain.com,uid1
user2@domain.com,uid2
user3@domain.com,uid3
```

### To delete firebase credentials for users
```
$ node firebase-admin-utils.js -c <path-to-firebase-admin-credentials> -i <input-file-containing-user-uid> -a delete
```

#### Sample Input file (containing uids of users to be deleted)

```
$ cat input.csv
uid
uid1
uid2
uid3
```

### To list all existing users in firebase
```
$ node firebase-admin-utils.js -c <path-to-firebase-admin-credentials> -o ename-to-write-user-info> -a list
```




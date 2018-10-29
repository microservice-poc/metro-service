# First we must generate a KeyStore file. To do that execute the following command
# The command will generate a file called jwt.jks which contains the Public and Private keys
keytool -genkeypair -alias jwt -keyalg RSA -keypass password -keystore jwt.jks -storepass password

# It is recommended to migrate to PKCS12. To do that execute the following command:
keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12

# Copy the jwt.jks file to the resources folder on Authentication server

# Now let's export the public key
# If it shows error as "openssl is not recognized as an internal or external command"
# Please download openssl from site: https://code.google.com/archive/p/openssl-for-windows/downloads
# Please add the openssl bin path to environment variable %PATH%
keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

# Copy from (including) -----BEGIN PUBLIC KEY----- to (including) ----- END PUBLIC KEY-----
# and save it in a text file. You will need this later in your resource servers.
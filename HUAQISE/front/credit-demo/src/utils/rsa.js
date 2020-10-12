import { JSEncrypt } from "jsencrypt";
//RSA 位数，这里要跟后端对应
const bits=1024

//当前JSEncrypted对象
let thisKeyPair={}

//生成密钥对(公钥和私钥)
export function rsa_generate(bits = bits) {
    let genKeyPair = {};
    thisKeyPair = new JSEncrypt({default_key_size: bits});

    //获取私钥
    genKeyPair.privateKey = thisKeyPair.getPrivateKey();

    //获取公钥
    genKeyPair.publicKey = thisKeyPair.getPublicKey();

    return genKeyPair;
}

//公钥加密
export function rsa_encrypt(plaintext, publicKey) {
    if (plaintext instanceof Object) {
        //1、JSON.stringify
        plaintext = JSON.stringify(plaintext)
    }
    publicKey && thisKeyPair.setPublicKey(publicKey);
    return thisKeyPair.encrypt(JSON.stringify(plaintext));
}

//私钥解密
export function rsa_decrypt(ciphertext, privateKey) {
    privateKey && thisKeyPair.setPrivateKey(privateKey);
    let decString =thisKeyPair.decrypt(ciphertext);
    if(decString.charAt(0) === "{" || decString.charAt(0) === "[" ){
        //JSON.parse
        decString = JSON.parse(decString);
    }
    return decString;
}



import CryptoJS from "crypto-js";


export function getKey(length = 16) {
    return "MIGfMA0GCSqGSIb3";
}

export function encrypt (plaintText,key){
    if (plaintText instanceof Object) {
        //JSON.stringify
        plaintText = JSON.stringify(plaintText)
    }
    var encrypted = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(plaintText), CryptoJS.enc.Utf8.parse(key), {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
    return encrypted.toString();
}
//解密
export function decrypt(ciphertext,key) {

    var decrypt = CryptoJS.AES.decrypt(ciphertext, CryptoJS.enc.Utf8.parse(key), {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
    var decString = CryptoJS.enc.Utf8.stringify(decrypt).toString();
    if(decString.charAt(0) === "{" || decString.charAt(0) === "[" ){
        //JSON.parse
        decString = JSON.parse(decString);
    }
    return decString;
}

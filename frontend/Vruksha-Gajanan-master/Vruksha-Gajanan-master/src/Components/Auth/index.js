import { EncryptStorage } from "encrypt-storage";
export const encryptStorage = new EncryptStorage("secret-key-value");

//login
export const login = (data, next) => {
  encryptStorage.setItem("data", JSON.stringify(data));
  next();
};

//logout
export const logout = () => {
  encryptStorage.removeItem("data");
};

//checking logged in user
export const checkLogin = () => {
  const data = encryptStorage.getItem("data");
  if (data) {
    const ob = JSON.parse(data);
    if (ob.token && ob.user) {
      return true;
    }
  }
  return false;
};

//get token
export const getToken = () => {
  if (checkLogin()) {
    // const data=encryptStorage.getItem("data")
    // const obj=JSON.parse(data);
    // ob.token;

    const token = JSON.parse(encryptStorage.getItem("data")).token;
    return token;
  } else {
    return null;
  }
};
//get current user
export const getCurrentUser = () => {
  if (checkLogin()) {
    const user = encryptStorage.getItem("data").user;
    return user;
  } else {
    return false;
  }
};

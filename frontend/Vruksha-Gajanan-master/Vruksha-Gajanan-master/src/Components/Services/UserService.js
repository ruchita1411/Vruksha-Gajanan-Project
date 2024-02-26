import axios from "axios";
const base_url = "http://localhost:9934";
export const createUser = (data) => {
  return axios.post(`${base_url}/users/`, data).then((response) => {
    response.data;
  });
};

export const loginUser = (data) => {
  return axios.post(`${base_url}/`, data).then((response) => {
    response.data;
  });
};

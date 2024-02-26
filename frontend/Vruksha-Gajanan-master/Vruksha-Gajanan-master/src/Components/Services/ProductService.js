import { http } from "./axios-helper";
export const loadProduct = () => {
  return http.get(`/product/view`).then((res) => res.data);
};

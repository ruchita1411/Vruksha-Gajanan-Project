import axios from "axios";
export const base_url = "http://localhost:9934";
export const http = axios.create({ baseURL: base_url });

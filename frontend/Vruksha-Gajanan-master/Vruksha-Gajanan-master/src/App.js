import Home from "./Components/Home";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer, toast } from "react-toastify";

import { Route, Routes, BrowserRouter } from "react-router-dom";
import SignUp from "./Components/SignUp";
import Login from "./Components/Login";
import Dashboard from "./Components/Dashboard";
import PrivateRoutes from "./Components/PrivateRoutes";
import Products from "./Components/Products";

function App() {
  return (
    <div>
      <BrowserRouter>
        <ToastContainer />

        <Routes>
          {/*<Route path="/dashboard" element={<Dashboard></Dashboard>}></Route>  ---public user route */}
          <Route path="/" element={<Home></Home>}>
            {" "}
          </Route>
          <Route path="/signup" element={<SignUp></SignUp>}></Route>
          <Route path="/login" element={<Login></Login>}></Route>
          <Route path="/products" element={<Products></Products>}></Route>
          {/**private route */}

          <Route path="user" element={<PrivateRoutes />}>
            <Route path="dashboard" element={<Dashboard />}></Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

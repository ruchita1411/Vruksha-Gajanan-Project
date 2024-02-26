import React from "react";
import CustomNavbar from "./CustomNavbar";

const Base = ({ children }) => {
  return (
    <div>
      <CustomNavbar />
      <div>{children}</div>
    </div>
  );
};

export default Base;

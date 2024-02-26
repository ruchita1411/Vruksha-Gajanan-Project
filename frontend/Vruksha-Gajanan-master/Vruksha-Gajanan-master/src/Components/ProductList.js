import React from "react";
import "./ProductList.css";
import { Button, CardBody, Container } from "reactstrap";
import img1 from "../images/img1.png";
import img2 from "../images/img2.png";
import img3 from "../images/img3.png";
import img4 from "../images/img4.png";
import img5 from "../images/img5.png";
import img6 from "../images/img6.png";
import img7 from "../images/img7.png";
import img8 from "../images/img8.png";
import img9 from "../images/img9.png";
import img10 from "../images/img10.png";

const ProductList = ({
  pname,
  pprice,
  pstock,
  pquantity,
  pimage,
  pdescription,
}) => {
  console.log("render products");
  return (
    <Container>
      <CardBody>
        <div className="pic">
          <img src={require(`../images/${pimage}`)} alt="loaing.."></img>
        </div>
      </CardBody>
      <CardBody>
        <div
          style={{
            marginLeft: "10px",
            display: "inline-block",
            marginBottom: "16px",
          }}
        >
          <div className="name" style={{ color: "#588157", fontSize: "20px" }}>
            <strong>{pname}</strong>
          </div>
          <div className="price">
            <span>₹</span>
            {pprice}
          </div>
          <div className="description">
            <strong>Description:</strong>{" "}
            <span style={{ marginLeft: "3%" }}>{pdescription}</span>
          </div>

          <div className="quantity">
            <strong>Quantity:</strong>{" "}
            <span style={{ marginLeft: "3%" }}>{pquantity}</span>
          </div>
          <div className="stock">
            <strong>Stock:</strong>{" "}
            <span style={{ marginLeft: "3%" }}>
              {pstock ? "Available" : "Stock Out"}
            </span>
          </div>
        </div>
        <CardBody style={{ display: "flex" }}>
          {" "}
          <Button className="m-2" color="success">
            View
          </Button>
          <Button className="m-2" color="success">
            Buy
          </Button>
        </CardBody>
      </CardBody>
    </Container>
  );
};

export default ProductList;

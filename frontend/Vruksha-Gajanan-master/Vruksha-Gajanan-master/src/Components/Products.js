import React, { useEffect, useState } from "react";
import Base from "./Base";
import ProductData from "./ProductData";
import "./Products.css";
import ProductList from "./ProductList";
import { Container } from "reactstrap";
import { loadProduct } from "../Components/Services/ProductService";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Products = () => {
  const [products, setProducts] = useState([]);
  console.log(products);
  useEffect(() => {
    getProduct();
  }, []);
  // const getProduct = () => {
  //   loadProduct()
  //     .then((data) => {
  //       console.log(data);
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });
  // };

  const getProduct = async () => {
    try {
      const res = await axios.get(
        `http://localhost:8080/products/get?pageNumber=0&pageSize=10`
      );
      if (res.status !== 200) {
        console.log(res);
        return;
      }
      // console.log(res.data.content);
      setProducts(res.data.content);
      // Navigate("/product");
    } catch (err) {
      console.log(err);
    }
  };
  return (
    <Base>
      <Container>
        <div className="Container" style={{ marginTop: "4rem" }}>
          {products.map((product) => (
            <ProductList
              key={product.id}
              pname={product.pname}
              pprice={product.pprice}
              pimage={product.pimage}
              pquantity={product.pquantity}
              pstock={product.pstock}
              pdescription={product.pdescription}
            ></ProductList>
          ))}
        </div>
      </Container>
    </Base>
  );
};

export default Products;

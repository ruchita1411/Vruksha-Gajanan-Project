import React from "react";
import Carousel from "react-bootstrap/Carousel";
import img1 from "../images/carousel1.jpg";
import img2 from "../images/carousel2.jpg";
import "../Components/Home.css";
import Base from "./Base";
import "bootstrap/dist/css/bootstrap.min.css";

const Home = () => {
  return (
    <Base>
      <Carousel>
        <Carousel.Item>
          <img className="d-block w-100" src={img1} alt="loading.."></img>
        </Carousel.Item>
        <Carousel.Item>
          <img className="d-block w-100" src={img1} alt="loading.."></img>
        </Carousel.Item>
        <Carousel.Item>
          <img className="d-block w-100" src={img1} alt="loading.."></img>
        </Carousel.Item>
      </Carousel>
    </Base>
  );
};

export default Home;

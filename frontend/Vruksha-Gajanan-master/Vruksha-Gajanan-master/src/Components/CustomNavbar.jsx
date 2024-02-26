import React from "react";
import { useState } from "react";
import "./CustomNavbar.css";
import img1 from "../images/vrukshaGajanan.png";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
} from "reactstrap";
import { checkLogin, getCurrentUser } from "./Auth";
function CustomNavbar() {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);
  return (
    <div>
      <Navbar
        fixed="marginTop"
        color="light"
        expand="md"
        className=" navbar px-5 shadow-lg navbar-fixed-top "
      >
        <NavbarBrand href="/" className="px-10 text-success">
          <img
            alt=""
            src={img1}
            style={{
              height: 40,
              width: 40,
            }}
          />{" "}
          Vruksha Gajanan
        </NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto  "></Nav>

          <Nav>
            {/*<UncontrolledDropdown nav inNavbar>
            <DropdownToggle nav caret>
              Products
            </DropdownToggle>
            <DropdownMenu right>
              <DropdownItem>Idols</DropdownItem>
              <DropdownItem>Decorations</DropdownItem>
            </DropdownMenu>
          </UncontrolledDropdown>*/}
            <NavItem>
              <NavLink href="/products/">Products</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/vision/">Our Vision</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/blog/">Blog</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/contact/">Contact</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/about/">About Us</NavLink>
            </NavItem>

            {checkLogin() && (
              <>
                <NavItem>
                  <NavLink href="/dashboard">{getCurrentUser().name}</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/signup/">Logout</NavLink>
                </NavItem>
              </>
            )}
            {!checkLogin() && (
              <>
                <NavItem>
                  <NavLink href="/login/">Login</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/signup/">SignUp</NavLink>
                </NavItem>
              </>
            )}
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
}

export default CustomNavbar;

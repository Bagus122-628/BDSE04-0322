import { useContext } from "react";
import { Button } from "react-bootstrap";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link, NavLink } from "react-router-dom";
import AuthContext from "../../../context/auth-context";

import "./NavigationBar.css";
import UserMenu from "./UserMenu";

const NavigationBar = (props) => {
  const authCtx = useContext(AuthContext);

  return (
    <Navbar expand="md" className={props.className}>
      <Container>
        <NavLink className="navbar-brand fw-bold text-white" to="/">
          xyz.cars
        </NavLink>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto me-md-auto">
            <NavLink
              activeclassname="active"
              className="nav-link text-uppercase fw-bold text-white me-3"
              to="/cars"
            >
              Home
            </NavLink>
            <NavLink
              activeclassname="active"
              className="nav-link text-uppercase fw-bold text-white"
              to="/post-car"
            >
              Sell a Car
            </NavLink>
            <NavLink
              activeclassname="active"
              className="nav-link text-uppercase fw-bold text-white"
              to="/webhook"
            >
              Webhook
            </NavLink>
          </Nav>
          {!authCtx.isLoggedIn && (
            <Nav>
              <Link to="/login">
                <Button
                  variant="outline-light"
                  className="me-0 me-md-3 mb-md-0 mb-3"
                >
                  Login
                </Button>
              </Link>
              <Link to="/register">
                <Button variant="primary" className="mb-sm-0 mb-3">
                  Register
                </Button>
              </Link>
            </Nav>
          )}
          {authCtx.isLoggedIn && (
            <Nav>
              <UserMenu />
            </Nav>
          )}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;

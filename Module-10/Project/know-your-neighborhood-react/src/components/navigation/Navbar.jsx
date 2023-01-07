import React, { useContext } from "react";
import { Link, NavLink, useNavigate } from "react-router-dom";
import AuthContext from "../../context/auth-context";

const link =
  "font-medium px-5 py-2 transition duration-300 rounded-md text-color2 hover:text-color1";
const loginClass =
  "font-medium px-5 py-2 transition duration-300 rounded-md border border-color1 text-color1 hover:opacity-70";
const registerClass =
  "font-medium px-5 py-2 transition duration-300 rounded-md border border-secondary text-primary bg-color1 hover:opacity-80";

const Navbar = () => {
  const authCtx = useContext(AuthContext);
  const navigate = useNavigate();
  const isLoggedIn = authCtx.isLoggedIn;

  const logoutHandler = () => {
    authCtx.logout();
    navigate("/login");
  };

  return (
    <nav className="bg-secondary flex justify-center items-center font-inter min-h-[60px] px-6 py-4">
      <div className="xl:max-w-[1280px] w-full flex justify-between items-center">
        <Link to="/" className="text-color1 font-bold text-3xl">
          KYN
        </Link>
        <ul className="md:flex space-x-3 hidden">
          <NavLink to="/stores" className={link}>
            Stores
          </NavLink>
          <NavLink to="/about" className={link}>
            About
          </NavLink>
          <NavLink to="/contact" className={link}>
            Contact
          </NavLink>

          {isLoggedIn && (
            <>
              <button className={loginClass} onClick={logoutHandler}>
                Logout
              </button>
              <NavLink to="/profile" className={registerClass}>
                Profile
              </NavLink>
            </>
          )}
          {!isLoggedIn && (
            <>
              <NavLink to="/login" className={loginClass}>
                Login
              </NavLink>
              <NavLink to="/register" className={registerClass}>
                Register
              </NavLink>
            </>
          )}
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;

import axios from "axios";
import { useContext, useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import AuthContext from "../../context/auth-context";
import "./AuthForm.css";

const LoginForm = () => {
  const authCtx = useContext(AuthContext);
  const inputUsernameRef = useRef();
  const inputPasswordRef = useRef();

  const navigate = useNavigate();

  const [loginStatus, setLoginStatus] = useState("");

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputUsername = inputUsernameRef.current.value;
    const inputPassword = inputPasswordRef.current.value;

    console.log(inputUsername);
    console.log(inputPassword);

    axios
      .post("http://localhost:8080/api/auth/login", {
        username: inputUsername,
        password: inputPassword,
      })
      .then((res) => {
        console.log(res);
        setLoginStatus("SUCCESS");
        authCtx.login(res.data.accessToken);
        navigate("/");
      })
      .catch((err) => {
        console.log(err.message);
        setLoginStatus("FAILED");
      });

    inputUsernameRef.current.value = "";
    inputPasswordRef.current.value = "";
  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth">
        <h3 className="mb-3 fw-semibold text-center">Login</h3>
        <form onSubmit={onSubmitHandler}>
          {loginStatus === "FAILED" && (
            <div className="form-error text-center">
              Username or password is invalid
            </div>
          )}
          <input
            ref={inputUsernameRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="username"
            placeholder="Username"
          />
          <input
            ref={inputPasswordRef}
            className="form-control mb-3 ps-4 pe-0"
            type="password"
            name="password"
            placeholder="Password"
          />
          <button type="submit" className="btn btn-primary btn-auth">
            Login
          </button>
          <Link
            to="/register"
            className="d-block mt-3 text-center text-decoration-none"
          >
            Create an account
          </Link>
        </form>
      </div>
    </div>
  );
};

export default LoginForm;

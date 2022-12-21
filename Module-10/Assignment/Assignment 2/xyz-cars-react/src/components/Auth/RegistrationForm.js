import axios from "axios";
import { useRef, useState } from "react";
import { Link } from "react-router-dom";
import "./AuthForm.css";

const RegistrationForm = () => {
  const inputUsernameRef = useRef();
  const inputPasswordRef = useRef();

  const [registerStatus, setRegisterStatus] = useState("");

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputUsername = inputUsernameRef.current.value;
    const inputPassword = inputPasswordRef.current.value;

    console.log(inputUsername);
    console.log(inputPassword);

    axios
      .post("http://localhost:8080/api/auth/register", {
        username: inputUsername,
        password: inputPassword,
      })
      .then((res) => {
        setRegisterStatus("SUCCESS");
        console.log(res);
      })
      .catch((err) => {
        setRegisterStatus("FAILED");
        console.log(err.message);
      });

    inputUsernameRef.current.value = "";
    inputPasswordRef.current.value = "";
  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth">
        <h3 className="mb-3 fw-semibold text-center">Register</h3>
        <form onSubmit={onSubmitHandler}>
          {registerStatus === "FAILED" && (
            <div className="form-error text-center">Register Failed</div>
          )}
          {registerStatus === "SUCCESS" && (
            <div className="form-success text-center">
              {inputUsernameRef.current.value} Register successfully!!
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
            Register
          </button>
          <Link
            to="/login"
            className="d-block mt-3 text-center text-decoration-none"
          >
            Already have an account?
          </Link>
        </form>
      </div>
    </div>
  );
};

export default RegistrationForm;

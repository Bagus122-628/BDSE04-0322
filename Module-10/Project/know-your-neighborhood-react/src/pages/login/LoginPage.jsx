import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import { FACEBOOK_URL } from "../../api/constant";
import { loginAPI } from "../../api/user-api";
import { facebookLogo } from "../../assets";
import FailedMessage from "../../components/form/FailedMessage";
import Input from "../../components/form/Input";
import MainLayout from "../../components/layout/MainLayout";

const LoginPage = () => {
  const [invalid, setInvalid] = useState(false);

  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm({ criteriaMode: "all" });

  const onSubmitHandler = (data) => {
    loginAPI(data.email, data.password)
      .then((res) => {
        console.log(res);
        setInvalid(false);
        reset();
      })
      .catch((err) => {
        setInvalid(true);
      });
  };

  return (
    <MainLayout>
      <div className="flex justify-center mt-10">
        <form
          onSubmit={handleSubmit(onSubmitHandler)}
          className="p-[30px] bg-secondary max-w-[400px] rounded-lg"
        >
          <h2 className="text-center font-semibold text-3xl mb-3">Login</h2>
          {invalid && (
            <FailedMessage
              onClose={() => {
                setInvalid(false);
              }}
            >
              Invalid username or password.
            </FailedMessage>
          )}

          <div className="mb-2">
            <Input
              label="Email"
              name="email"
              type="text"
              errors={errors}
              placeholder="Enter your email"
              register={register}
              validation={{
                required: "Please enter email address",
                pattern: {
                  value: /^\S+@\S+$/i,
                  message: "Please enter valid email",
                },
              }}
            />
          </div>

          <div className="mb-2">
            <Input
              label="Password"
              name="password"
              type="password"
              errors={errors}
              placeholder="Enter your password"
              register={register}
              validation={{
                required: "Please enter password",
              }}
            />
          </div>

          <button
            type="submit"
            className="py-3 mt-3 rounded-md border border-secondary text-primary bg-color1 w-full"
          >
            Login
          </button>
          <a
            href={FACEBOOK_URL}
            className="flex justify-center py-3 rounded-md border mt-4 text-primary bg-color2"
          >
            <img
              src={facebookLogo}
              alt="facebook"
              className="w-[24px] h-[24px] mr-1"
            />
            Login with Facebook
          </a>
        </form>
      </div>
    </MainLayout>
  );
};

export default LoginPage;

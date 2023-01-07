import React, { useState } from "react";
import { useForm } from "react-hook-form";
import FailedMessage from "../components/form/FailedMessage";
import Input from "../components/form/Input";
import MainLayout from "../components/layout/MainLayout";

const AddStorePage = () => {
  const [status, setStatus] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm({ criteriaMode: "all" });

  const onSubmitHandler = (data) => {};
  return (
    <MainLayout>
      <div className="flex justify-center mt-10">
        <form
          onSubmit={handleSubmit(onSubmitHandler)}
          className="p-[30px] bg-secondary w-full max-w-[500px] rounded-lg shadow-md shadow-primary"
        >
          <h2 className="text-center font-semibold text-3xl mb-3">Add Store</h2>

          {status === "FAILED" && (
            <FailedMessage onClose={() => setStatus("")}>
              {errorMessage}
            </FailedMessage>
          )}

          <Input
            label="Store Name*"
            name="storeName"
            type="text"
            errors={errors}
            placeholder="Enter store name"
            register={register}
            validation={{
              required: "Password is required",
            }}
          />

          <button
            type="submit"
            className="py-3 mt-3 rounded-md border border-secondary text-primary bg-color1 w-full"
          >
            Register
          </button>
        </form>
      </div>
    </MainLayout>
  );
};

export default AddStorePage;

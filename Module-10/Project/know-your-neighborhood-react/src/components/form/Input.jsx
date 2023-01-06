import React from "react";

const Input = React.forwardRef(
  ({ label, name, register, type, placeholder, validation, errors }, ref) => {
    const errorMessage = (
      <p className="flex items-end text-red-400 font-normal">
        {errors[name]?.message}
      </p>
    );

    const invalid =
      errors &&
      (errors[name]?.type === "required" ||
        errors[name]?.type === "minLength" ||
        errors[name]?.type === "pattern");

    return (
      <>
        <label htmlFor={name} className="block font-normal mb-1 text-lg">
          {label}
        </label>
        <input
          ref={ref}
          type={type}
          placeholder={placeholder}
          className={`py-1 px-3 rounded w-full text-primary mb-1 ${
            invalid ? "bg-red-200 border-red-200" : ""
          }`}
          {...register(name, { ...validation })}
        />
        {errors && errors[name]?.type === "required" && errorMessage}
        {errors && errors[name]?.type === "minLength" && errorMessage}
        {errors && errors[name]?.type === "pattern" && errorMessage}
      </>
    );
  }
);

export default Input;

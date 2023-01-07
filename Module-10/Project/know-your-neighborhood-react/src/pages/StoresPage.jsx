import React from "react";
import { Link } from "react-router-dom";
import MainLayout from "../components/layout/MainLayout";

const StoresPage = () => {
  return (
    <MainLayout>
      <Link to="add" className="text-primary">
        Add Store
      </Link>
    </MainLayout>
  );
};

export default StoresPage;

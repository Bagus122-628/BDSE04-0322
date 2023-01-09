import React from "react";
import { Link } from "react-router-dom";
import MainLayout from "../../components/layout/MainLayout";
import StoreCard from "../../components/stores/StoreCard";
import useListStore from "../../hooks/useListStore";

const StoresPage = () => {
  const { stores } = useListStore();

  return (
    <MainLayout>
      <Link to="add" className="block text-color1 mb-5">
        Add Store
      </Link>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 mt-1 gap-4">
        {stores.map((store) => (
          <StoreCard store={store} />
        ))}
      </div>
    </MainLayout>
  );
};

export default StoresPage;

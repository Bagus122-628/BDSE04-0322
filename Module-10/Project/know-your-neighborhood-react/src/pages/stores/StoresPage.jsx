import React from "react";
import { Link } from "react-router-dom";
import MainLayout from "../../components/layout/MainLayout";
import useListStore from "../../hooks/useListStore";

const StoresPage = () => {
  const { stores } = useListStore();

  return (
    <MainLayout>
      <Link to="add" className="block text-color1 mb-5">
        Add Store
      </Link>
      {stores.map((store, index) => (
        <div className="text-primary mb-5" key={store.storeId}>
          <p>
            {index + 1}. {store.storeName}
          </p>
          <Link
            to={`${store.storeName}/${store.storeId}`}
            className="block text-color1 "
          >
            Detail
          </Link>
        </div>
      ))}
    </MainLayout>
  );
};

export default StoresPage;

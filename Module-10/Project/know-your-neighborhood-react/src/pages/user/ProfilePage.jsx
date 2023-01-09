import React, { useContext } from "react";
import { Link, useParams } from "react-router-dom";
import { userDefault } from "../../assets";
import MainLayout from "../../components/layout/MainLayout";
import StoreCard from "../../components/stores/StoreCard";
import AuthContext from "../../context/auth-context";

const ProfilePage = () => {
  const { profile, stores } = useContext(AuthContext);
  const profilePicture = profile.imageUrl;
  const params = useParams();

  return (
    <MainLayout>
      <div className="flex w-full md:max-w-[700px] mt-8 py-4 px-5 rounded-lg bg-white shadow shadow-gray-300">
        <img
          src={profilePicture ? profilePicture : userDefault}
          alt="profile_picture"
          className="rounded-full
            w-24 h-24 sm:w-40 sm:h-40 mr-5"
        />
        <div className="mt-2 font-inter font-medium text-gray-400 w-full">
          <h3 className="text-2xl md:text-3xl text-primary mb-1 pb-2 border-b">
            {profile.name}
          </h3>
          <div className="grid grid-cols-1 gap-2">
            <div>
              <p className="text-secondary">Email</p>
              <p>{profile.email}</p>
            </div>
            <div>
              <p className="text-secondary">Address</p>
              <p>{profile.address}</p>
            </div>
            <div>
              <p className="text-secondary">Phone Number</p>
              <p>{profile.phoneNumber}</p>
            </div>
          </div>
        </div>
      </div>
      <div className="mt-5 mb-10">
        <div className="border-b-2 border-gray-300 mb-3 pb-1">
          <h2 className="font-inter text-4xl font-bold drop-shadow ">Stores</h2>
        </div>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 mt-1 gap-5">
          {stores.map((store) => (
            <StoreCard store={store} />
          ))}
          {stores.length <= 0 && (
            <p className="text-gray-500">No store available</p>
          )}
        </div>
      </div>
    </MainLayout>
  );
};

export default ProfilePage;

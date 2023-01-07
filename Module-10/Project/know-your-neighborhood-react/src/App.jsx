import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import AddStorePage from "./pages/stores/AddStorePage";
import StoreDetailPage from "./pages/stores/StoreDetailPage";
import EditStorePage from "./pages/stores/EditStorePage";
import StoresPage from "./pages/stores/StoresPage";
import EditProfilePage from "./pages/user/EditProfilePage";
import ProfilePage from "./pages/user/ProfilePage";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/">
      <Route index element={<HomePage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/stores">
        <Route index element={<StoresPage />} />
        <Route path="add" element={<AddStorePage />} />
        <Route path=":storeName/:storeId" element={<StoreDetailPage />} />
        <Route path=":storeName/:storeId/edit" element={<EditStorePage />} />
      </Route>
      <Route path="/profile">
        <Route index element={<ProfilePage />} />
        <Route path="edit" element={<EditProfilePage />} />
      </Route>
    </Route>
  )
);

function App() {
  return <RouterProvider router={router} />;
}

export default App;

import Footer from "./Footer/Footer";
import NavigationBar from "./Navigation/NavigationBar";

import "./Layout.css";
import Sidebar from "./Sidebar/Sidebar";
import SearchByKeyword from "../Search/SearchByKeywordForm";

const Layout = (props) => {
  return (
    <div className="layout">
      <NavigationBar className="navbar" />
      <main className="container d-flex mt-4 mb-4">
        <Sidebar />
        <div className="content">
          <SearchByKeyword />
          {props.children}
        </div>
      </main>
      <Footer className="footer" />
    </div>
  );
};

export default Layout;

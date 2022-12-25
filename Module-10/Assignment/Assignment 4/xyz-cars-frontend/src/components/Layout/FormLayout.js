import Footer from "./Footer/Footer";
import NavigationBar from "./Navigation/NavigationBar";

import "./Layout.css";

const FormLayout = (props) => {
  return (
    <div className="layout">
      <NavigationBar className="navbar" />
      <main className="container  mt-4 mb-4">{props.children}</main>
      <Footer className="footer" />
    </div>
  );
};

export default FormLayout;

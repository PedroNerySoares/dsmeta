import React from "react";
import Header from "./components/Header";
import NotificationButon from "./components/NotificationButton";
import SalesCard from "./components/SalesCard";

import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />

          </div>
        </section>
      </main>
    </>
  );
}

export default App;

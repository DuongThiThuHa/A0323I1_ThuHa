import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import React from "react";
import CreateProduct from "./components/Products/CreateProduct";
import ProductList from "./components/Products/ProductList";
import {ToastContainer} from "react-toastify";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/product/create" element={<CreateProduct/>}></Route>
                    <Route path="/product" element={<ProductList />} />
                </Routes>
            </BrowserRouter>
            <ToastContainer/>
        </>
    );
}

export default App;

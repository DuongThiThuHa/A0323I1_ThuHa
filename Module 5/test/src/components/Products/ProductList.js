import React, { useEffect, useState } from "react";
import * as productService from "../Service/ProductService";
import { deburr } from 'lodash';
import "bootstrap/dist/css/bootstrap.css";
import { Link, useNavigate } from "react-router-dom";

function ProductList(props) {
    const navigate = useNavigate();
    const [products, setProducts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        getAllProducts();
    }, []);

    const getAllProducts = async () => {
        try {
            const productsData = await productService.getAll();
            setProducts(productsData);
        } catch (error) {
            console.error("Error fetching products:", error);
        }
    }

    const filteredProducts = products.filter(product => {
        const normalizedSearchTerm = deburr(searchTerm.toLowerCase());
        const normalizedName = deburr(product.name.toLowerCase());
        return normalizedName.includes(normalizedSearchTerm);
    });

    return (
        <>
            <h1 style={{ color: "navy", textAlign: "center" }}>Products List {props.className}</h1>
            <div className="search">
                <input
                    type="text"
                    placeholder="Search..."
                    className="promt"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    style={{ borderRadius: "15px", width: "30%", float: "right" }}
                />
            </div>

            <button type="button" className="btn btn-outline-primary" style={{ float: "left" }} onClick={() => navigate("/product/create")}>
                Create
            </button>

            <table className="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Date</th>
                    <th>Desc</th>
                </tr>
                </thead>

                <tbody>
                {filteredProducts.map((item, index) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.type}</td>
                        <td>{item.price}</td>
                        <td>{item.quantity}</td>
                        <td>{item.date}</td>
                        <td>{item.desc}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    )
}

export default ProductList;

import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import * as Yup from 'yup';
import * as typeProductService from "../Service/ProductService";
import * as productService from "../Service/ProductService";
import { toast } from "react-toastify";
import { ErrorMessage, Field, Form, Formik } from "formik";

function CreateProduct() {
    const navigate = useNavigate();
    const [type, setType] = useState([]);
    const initialValues = {
        name: "",
        type: "",
        price: "",
        quantity: "",
        date: "",
        desc: ""
    };

    const validationProduct = Yup.object().shape({
        name: Yup.string().required("Name not null"),
        price: Yup.number()
            .required("Price not null")
            .min(0, "Price must be greater than or equal to 0")
            .max(10000000, "Price must be less than or equal to 10000000"),
        quantity: Yup.number()
            .required("Quantity not null")
            .min(0, "Quantity must be greater than or equal to 0")
            .max(1000, "Quantity must be less than or equal to 1000"),
        date: Yup.date().required("Date not null"),
    });

    useEffect(() => {
        getAllType();
    }, []);

    const getAllType = async () => {
        try {
            const temp = await typeProductService.getAll();
            setType(temp);
        } catch (error) {
            console.error("Error fetching types:", error);
        }
    };

    const addNewProduct = async (values) => {
            await productService.add(values);
            toast.success("Success!");
            navigate("/product");
    };

    return (
        <Formik initialValues={initialValues} onSubmit={addNewProduct} validationSchema={validationProduct}>
            <Form>
                Name: <Field name="name" />
                <ErrorMessage name="name" component="p" />

                Type:
                <Field as="select" name="type">
                    <option value="" disabled>--Select type--</option>
                    {type.map((a) => (
                        <option value={a.id} key={a.id}>{a.typeProduct}</option>
                    ))}
                </Field>
                <ErrorMessage name="type" component="p" />

                Price: <Field name="price" />
                <ErrorMessage name="price" component="p" />

                Quantity: <Field name="quantity" />
                <ErrorMessage name="quantity" component="p" />

                Date: <Field type="date" name="date" />
                <ErrorMessage name="date" component="p" />

                Desc: <Field name="desc" />
                <ErrorMessage name="desc" component="p" />

                <button type="submit">Add a product</button>
            </Form>
        </Formik>
    );
}

export default CreateProduct;

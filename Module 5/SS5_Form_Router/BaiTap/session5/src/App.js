import React, { useState } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';

function App() {
    const [books, setBooks] = useState([]);
    const [form, setForm] = useState({});
    const [indexSelected, setIndexSelected] = useState(-1);

    const handleSelect = (book, index) => {
        setForm({ ...book });
        setIndexSelected(index);
    };

    const handleDelete = (index) => {
        let newBooks = [...books];
        newBooks.splice(index, 1);
        setBooks(newBooks);
        setForm({});
        setIndexSelected(-1);
    };

    const handleSubmit = (values, { resetForm }) => {
        let newBooks = [...books];
        if (indexSelected > -1) {
            newBooks.splice(indexSelected, 1, values);
        } else {
            newBooks.push(values);
        }
        setBooks(newBooks);
        resetForm();
        setForm({});
        setIndexSelected(-1);
    };

    const handleEdit = (values) => {
        setForm(values);
    };

    const handleCreate = () => {
        setForm({});
        setIndexSelected(-1);
    };

    return (
        <div>
            <h1>Book Form</h1>
            <Formik
                initialValues={{ title: form.title || '', number: form.number || '' }}
                validate={values => {
                    const errors = {};
                    if (!values.title) {
                        errors.title = 'Required';
                    }
                    if (!values.number) {
                        errors.number = 'Required';
                    } else if (isNaN(values.number)) {
                        errors.number = 'Invalid number';
                    }
                    return errors;
                }}
                onSubmit={handleSubmit}
            >
                {({ isSubmitting }) => (
                    <Form>
                        <label>Title:</label>
                        <Field type="text" name="title" />
                        <ErrorMessage name="title" component="div" />

                        <label>Number:</label>
                        <Field type="text" name="number" />
                        <ErrorMessage name="number" component="div" />

                        <button type="submit" disabled={isSubmitting}>Submit</button>
                        <button type="button" onClick={handleCreate}>Create</button>
                    </Form>
                )}
            </Formik>

            <h1>Book List</h1>
            <table>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Number</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {books.map((book, index) => (
                    <tr key={index}>
                        <td>{book.title}</td>
                        <td>{book.number}</td>
                        <td>
                            <button type="button" onClick={() => handleEdit(book)}>Edit</button>
                            <button type="button" onClick={() => handleDelete(index)}>Delete</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default App;

import React from 'react';
import "bootstrap/dist/css/bootstrap.css";

function Alert(props) {
    return (
        <>
            <div className="alert alert-primary" role="alert">
                {props.text}
            </div>
        </>
    );
};
export default Alert;

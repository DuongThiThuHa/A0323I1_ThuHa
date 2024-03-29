import React from 'react';
import "bootstrap/dist/css/bootstrap.css";


const AlertComponent = (props) => {
    return (
        <>
            <div className="alert alert-primary" role="alert">
                Cảnh báo! Tài nguyên bạn vừa truy cập không tồn tại.
            </div>
        </>
    );
};

export default AlertComponent;

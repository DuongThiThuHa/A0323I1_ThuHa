import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import useClock from "../hook/UseClock";



function Clock() {
    // Goi custom hook de su dung
    const [time, value] = useClock();
    return (
        <>
            <div class="btn btn-outline-success">{time}</div>
            <span>{value}</span>
        </>
    );
}

export default Clock;
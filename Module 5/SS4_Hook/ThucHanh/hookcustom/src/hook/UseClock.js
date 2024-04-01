import {useState} from "react";

export default function useClock() {
    const [time, setCurrentTime] = useState("");
    const [value, setValueTime] = useState("");

    const updateTime = function () {
        const dateInfor = new Date();
        var hour = 0;

        //Lay gia tri cua gio
        if (dateInfor.getHours() === 0) {
            hour = 12;
        } else if (dateInfor.getHours() > 12) {
            hour = dateInfor.getHours() - 12;
        } else {
            hour = dateInfor.getHours();
        }

        //Lay gia tri cua phut
        var minutes =
            dateInfor.getMinutes() < 10 ? parseInt("0" + dateInfor.getMinutes()) : dateInfor.getMinutes();

        // Lay gia tri cua giay
        var second =
            dateInfor.getSeconds() < 10 ? "0" + dateInfor.getSeconds() : dateInfor.getSeconds();

        //Dinh dang ngay
        var value = dateInfor.getHours() >= 12 ? "PM" : "AM";

        //Cap nhap state
        setValueTime(value);
        setCurrentTime(`${hour}: ${minutes}:${second}`);
    };

    setInterval(function () {
        updateTime();
    }, 1000);

    return [time, value]
}


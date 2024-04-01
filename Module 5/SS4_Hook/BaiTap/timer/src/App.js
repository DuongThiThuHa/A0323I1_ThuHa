import React, { useState, useEffect } from 'react';

const Timer = () => {
  // Khởi tạo state timer với giá trị = 10
  const [timer, setTimer] = useState(10);

  // Khai báo hàm useEffect
  useEffect(() => {
    // Sử dụng setInterval() để thực hiện trừ timer sau mỗi 1 giây
    const intervalId = setInterval(() => {
      setTimer((prevTimer) => {
        if (prevTimer > 0) {
          return prevTimer - 1;
        } else {
          alert("Time's up");
        }
      });
    }, 1000);

    // Clean up effect
    return () => {
      clearInterval(intervalId);
    };
  }, []);

  return <div>Count down from: {timer} </div>;
};

export default Timer;

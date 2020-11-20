CREATE TABLE Book (
    bid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), -- 主鍵序號
    bname varchar(20) not null, -- 書名
    price INTEGER, -- 價格 
    ct timestamp default current_timestamp, -- 建檔時間
    PRIMARY KEY (bid)
);

CREATE TABLE Stock (
    sid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), -- 主鍵序號
    bid INTEGER NOT NULL,
    amount INTEGER, -- 數量 
    PRIMARY KEY (sid)
);

CREATE TABLE Wallet (
    wid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), -- 主鍵序號
    money INTEGER, -- 數量 
    PRIMARY KEY (wid)
);

import React, { useEffect, useState } from "react";
import { DataGrid } from "@mui/x-data-grid";
import Button from "@mui/material/Button";
import axios  from "axios"
import AddUpdateBookDialog from "./Dialogs/AddUpdateBookDialog";
import EnumDialogActionType from "../enums/EnumDialogActionType";

const columns = [
    { field: "id",              headerName: "ID",               width: 100 },
    { field: "title",           headerName: "Title",            width: 300 },
    { field: "author",          headerName: "Author",           width: 200 },
    { field: "publicationYear", headerName: "Publication Year", width: 200 },
    { field: "isAvailable",     headerName: "Avaiblity",        width: 200 },
];

function BookList() {

    const [books, setBooks] = useState([]);
    const [selectedRowId, setSelectedRowId]     = useState(null);
    const [isAddDialogOpen, setIsAddDialogOpen] = useState(false);
    const [action, setAction] = useState(null);
    const [selectedBook, setSelectedBook] = useState({
        id: "",
        title: "",
        author: "",
        publicationYear: "",
        isAvailable: false,
    });

    useEffect(() =>  {
        getBookList();
    }, [])

    const getBookList = () => {
        axios.get("http://localhost:8090/api/books")
        .then((res) => {
            const bookList = Array.isArray(res.data.book) ? res.data.book : [];

            console.log(bookList)
            setBooks(bookList);
        })
        .catch((err) => {
            console.error(err)
        });
    }

    const handleDeleteClick = () => {

        if (selectedRowId == undefined) {
            return;
        }

        axios.delete(`http://localhost:8090/api/books/${selectedRowId}`)
        .then((res) => {
            console.log("Response: ", res.data)
            getBookList();
        })
        .catch((err) => {
            console.error(err)
        });
    }

    const handleUpdateClick = () => {

        if (selectedRowId == undefined) {
            return;
        }

        const selectedRow = books.find((row) => row.id === selectedRowId);
        setSelectedBook(selectedRow);
        setAction(EnumDialogActionType.UPDATE);
        setIsAddDialogOpen(true);
    }

    const handleAddClick = () => {
        setSelectedBook({
            id: "",
            title: "",
            author: "",
            publicationYear: "",
            isAvailable: false,
        });
        setAction(EnumDialogActionType.ADD)
        setIsAddDialogOpen(true);
    }


    const addNewBook = (newBook, action) => {
        if (action == EnumDialogActionType.ADD.value) {
            axios.post("http://localhost:8090/api/books", newBook)
            .then((res) => {
                console.log("Response: ", res.data)
                getBookList();
            })
            .catch((err) => {
                console.error(err)
            });
        } else if (action == EnumDialogActionType.UPDATE.value) {
            axios.put("http://localhost:8090/api/books", newBook)
            .then((res) => {
                console.log("Response: ", res.data)
                getBookList();
            })
            .catch((err) => {
                console.error(err)
            });
        }

        setIsAddDialogOpen(false);
    } 

    return (
        <>
            <DataGrid
                rows={books || []}
                columns={columns}
                pageSizeOptions={[5, 10, 25, { value: -1, label: 'All' }]}
                checkboxSelection
                disableMultipleRowSelection
                initialState={{
                    pagination: { paginationModel: { pageSize: 5 } },
                }}
                onRowSelectionModelChange={(newSelection) => {
                    const selectedId = Array.from(newSelection.ids)[0];
                    setSelectedRowId(selectedId);
                }}
            />
            <div 
                style={{ 
                    display: "flex", 
                    flexDirection: "row-reverse",
                    margin: "20px 0px 0px 0px",
                }}
            >
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleDeleteClick()}>DELETE</Button>
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleUpdateClick()}>UPDATE</Button>
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleAddClick()}>ADD</Button>
            </div>
            <AddUpdateBookDialog
                open={isAddDialogOpen}
                selectedBook={selectedBook}
                action={action}
                handleClose={() => setIsAddDialogOpen(false)}
                onSubmit={(newBook) => addNewBook(newBook, action.value)}
            />
        </>
    );
}

export default BookList;

import React, { useState, useEffect, act } from "react";
import {
    Dialog,
    DialogTitle,
    DialogContent,
    DialogActions,
    TextField,
    Button,
    FormControlLabel,
    Checkbox,
} from "@mui/material";

function AddUpdateBookDialog({ open, selectedBook, action, handleClose, onSubmit }) {
    
    const [book, setBook] = useState({  
        id: "",
        title: "",
        author: "",
        publicationYear: "",
        isAvailable: false
    });

    useEffect(() =>  {
        setBook(selectedBook);
    }, [selectedBook])

    const handleChange = (e) => {
        const { name, value } = e.target;
        setBook({ ...book, [name]: value });
    };

    const handleCheckboxChange = (e) => {
        setBook({ ...book, isAvailable: e.target.checked });
    };

    const handleSubmit = () => {
        onSubmit(book);
        setBook({
            id: "",
            title: "",
            author: "",
            publicationYear: "",
            isAvailable: false,
        });
    };

    return (
        <Dialog open={open} onClose={handleClose}>
            <DialogTitle> {action?.label} a Book</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    name="id"
                    label="ID"
                    type="number"
                    fullWidth
                    value={book.id}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="title"
                    label="Title"
                    fullWidth
                    value={book.title}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="author"
                    label="Author"
                    fullWidth
                    value={book.author}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="publicationYear"
                    label="Publication Year"
                    type="date"
                    fullWidth
                    InputLabelProps={{ shrink: true }}
                    value={book.publicationYear}
                    onChange={handleChange}
                />
                <FormControlLabel
                    control={
                        <Checkbox
                            checked={book.isAvailable}
                            onChange={handleCheckboxChange}
                            name="isAvailable"
                        />
                    }
                    label="Available"
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={handleClose}>Cancel</Button>
                <Button onClick={handleSubmit}>{action?.label}</Button>
            </DialogActions>
        </Dialog>
  );
}

export default AddUpdateBookDialog;

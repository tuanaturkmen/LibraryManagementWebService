import React, { useEffect, useState } from "react";
import BookList    from './components/BookList'
import StudentList from "./components/StudentList";
import { Tabs, Tab, Box, Typography } from "@mui/material";
import './App.css'

function App() {

	const [tabIndex, setTabIndex] = useState(0);

	const handleChange = (event, newIndex) => {
		setTabIndex(newIndex);
  	};

	return (
		<>
			<h1
				style={{
					margin: '60px 0px 30px 0px',
					fontFamily: 'system-ui, Avenir, Helvetica, Arial, sans-serif',
				}}
			>
				Library Management System
			</h1>
			<Tabs
				value={tabIndex}
				onChange={handleChange}
			>
				<Tab label="Books"></Tab>
				<Tab label="Students"></Tab>
			</Tabs>
			{ tabIndex == 0 && <BookList></BookList> }
			{ tabIndex == 1 && <StudentList></StudentList> }
		</>
	)
}

export default App

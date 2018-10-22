<?php
 
class DbOperation
{
    //Database connection link
    private $con;
 
    //Class constructor
    function __construct()
    {
        //Getting the DbConnect.php file
        require_once dirname(__FILE__) . '/DbConnect.php';
 
        //Creating a DbConnect object to connect to the database
        $db = new DbConnect();
 
        //Initializing our connection link of this class
        //by calling the method connect of DbConnect class
        $this->con = $db->connect();
    }
	
	
	/*
	* The read operation
	* When this method is called it is returning all the existing record of the database
	*/
	function getPerson(){
		$stmt = $this->con->prepare("SELECT id, firstname, lastname, birthday, email, mobilenumber, address, contactperson, contactpersonnumber FROM person");
		$stmt->execute();
		$stmt->bind_result($id, $firstname, $lastname, $birthday, $email, $mobilenumber, $address, $contactperson, $contactpersonnumber);
		
		$perons = array(); 
		
		while($stmt->fetch()){
			$person  = array();
			$person['id'] = $id; 
			$person['firstname'] = $firstname; 
			$person['lastname'] = $lastname; 
			$person['birthday'] = $birthday; 
			$person['email'] = $email; 
			$person['mobilenumber'] = $mobilenumber; 
			$person['address'] = $address; 
			$person['contactperson'] = $contactperson; 
			$person['contactpersonnumber'] = $contactpersonnumber; 
			
			array_push($perons, $person); 
		}
		
		return $perons; 
	}
}
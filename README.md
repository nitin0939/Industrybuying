# Industrybuying
Please find the problem below. 

File Link: https://www.dropbox.com/s/quuz0gx3d1tis7x/cunique.csv?dl=0
 
( Note: The file also attached to this email in Zipped format.)
 
1. Download the above file and write a spring boot application to import the file into MySQL or any other SQL/NO-SQL data store. The columns in the first rows of the excel sheet will be used as columns in the MySQL table. The data importer should be efficient in terms of loading huge data sets into the database. For example, it should be written so as to load 5M rows if required.
 
2. Write a search API endpoint that will take a keyword from the user as input and then search all the matching messages which contain the entered keyword and output the result as follows. The aim is to search the messages containing the keyword and prepare a JSON response.
 
API Endpoint: /search?query={QUERY_INPUT}   where QUERY_INPUT is the input entered by the user. 
 
Example: /search?query=bank
 
Expected Output:
{
   "total_matches":1000,
   "truth":{
      "spam":500,
      "not-spam":500
   },
   "cube":{
      "spam":520,
      "not-spam":480
   },
   "google":{
      "spam":530,
      "not-spam":470,
      "avg-spam-score":0.55,        // Average of all the spam score of all matching messages
      "avg-not-spam-score":0.45   // Average of all the not-spam score of all matching messages
   },
   "ibm":{
      "spam":550,
      "not-spam":450,
      "avg-spam-score":0.51,
      "avg-not-spam-score":0.49
   }
}



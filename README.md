# chirpMessage
Message formatter

Requirements
Write an application to format the given data for Chirp Views into a single string, based on the following requirements:

Format the data into a string as follows: a. The chirp message itself b. The date of the chirp in MM/DD/YYYY format c. The number of views the chirp has d. The author’s name 
e. A fire emoji if the chirp has more than 100,000 views.
If the formatted string exceeds 140 characters, truncate the chirp message, and append “…” to it until the truncated message and remaining content can fit into 140 characters.

Example, if the following data were given, it the following outputs would be expected:

Message: Hello World! Author: Jack Daniels Date: 2021-06-28T07:00:00.000Z Views: 99999 Formatted Output: Hello World! 06/28/2021 99999 Jack Daniels
Message: This is a maximum length chirp because I like writing long chirps. Why? I'm not really sure. Maybe I'm just a rebel.. or maybe it's a phase? Author: John Smith Date: 2021-04-22T00:00:00.000Z Views: 100 Formatted Output: This is a maximum length chirp because I like writing long chirps. Why? I'm not really sure. Maybe I'm just a r... 04/22/2021 100 John Smith
Message: This chirp probably won't get a lot of attention. Author: Jane Doe Date: 2021-03-04T04:00:00.000Z Views: 251236 Formatted Output: This chirp probably won't get a lot of attention. 03/04/2021 251236 Jane Doe 🔥

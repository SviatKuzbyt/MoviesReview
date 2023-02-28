package com.example.moviesreview.data.temp

import com.example.moviesreview.R
import com.example.moviesreview.data.database.Movies
import com.example.moviesreview.data.database.MoviesDao

class InitDataBase(private val dao: MoviesDao){
    private val data = listOf(
        Movies(
            0,
            "Hangover",
            "poster0.jpg",
            false,
            "http://www.youtube.com/watch?v=4jk43p4IBQc",
            "https://www.youtube.com/watch?v=QqVFXyaRL90",
            7.7f,
            "June 5, 2009",
            "USA",
            "Comedy",
            "1hr 40min",
            "Bradley Cooper, Ed Helms, Zach Galifianaki",
            "The company of friends decides to celebrate the bachelor party, and goes to Las Vegas for this. Upon arrival at the site, the guys partying all night long. But when they wake up in the morning, they find a mess in the room, in the closet of a baby, in the bathroom of a real tiger, and most importantly, that the celebrity is missing. Trying to remember nothing, and then they decide to try to recover step by step what happened at night. That’s where it gets interesting...",
            "film",
            true
        ),
        Movies(
            0,
            "Mean Girls",
            "poster1.jpg",
            false,
            "https://youtu.be/oDU84nmSDZY",
            "http://www.youtube.com/watch?v=3raLsO_LVVc",
            7.0f,
            "April 30, 2004",
            "USA",
            "Comedy, Drama",
            "1hr 37min",
            "Lindsay Lohan, Rachel McAdams, Tina Fey",
            "Lindsay Lohan stars as Cady Heron, a 16 year old homeschooled girl who not only makes the mistake of falling for Aaron Samuels (Jonathan Bennett), the ex-boyfriend of queenbee Regina George (Rachel McAdams), but also unintentionally joins The Plastics, led by Regina herself. Join Cady as she learns that high school life can and will be really tough.",
            "film",
            false
        ),
        Movies(
            0,
            "The Office",
            "poster2.jpg",
            false,
            "https://www.primevideo.com/dp/amzn1.dv.gti.7cb027c1-a767-2c73-f659-9fcb9d1064a7?autoplay=0&ref_=atv_cf_strg_wb",
            "https://youtu.be/2iKZmRR9AR4",
            8.8f,
            "March 24, 2005",
            "USA",
            "Sitcom, Comedy",
            "9 seasons (22 minutes)",
            "Steve Carell, Jenna Fischer, John Krasinski, Rainn Wilson",
            "A mediocre paper company in the hands of Scranton, PA branch manager Michael Scott. This mockumentary follows the everyday lives of the manager and the employees he \"manages.\" The crew follows the employees around 24/7 and captures their quite humorous and bizarre encounters as they will do what it takes to keep the company thriving.",
            "serial",
            true
        ),
        Movies(
            0,
            "Brooklyn Nine-Nine",
            "poster3.jpg",
            false,
            "https://www.netflix.com/watch/70281562?source=35",
            "https://www.youtube.com/watch?v=icTOP9F17pU",
            8.4f,
            "September 17, 2013",
            "USA",
            "Sitcom, Comedy",
            "6 seasons (22 minutes)",
            "Andy Samberg, Stephanie Beatriz, Terry Crews, Melissa Fumero",
            "Captain Ray Holt takes over Brooklyn's 99th precinct, which includes Detective Jake Peralta, a talented but carefree detective who's used to doing whatever he wants. The other employees of the 99th precinct include Detective Amy Santiago, Jake's over achieving and competitive partner; Detective Rosa Diaz, a tough and kept to herself coworker; Detective Charles Boyle, Jake's best friend who also has crush on Rosa; Detective Sergeant Terry Jeffords, who was recently taken off the field after the birth of his twin girls; and Gina Linetti, the precinct's sarcastic administrator.",
            "serial",
            false
        ),
        Movies(
            0,
            "Friends",
            "poster4.jpg",
            false,
            "https://www.netflix.com/in/title/70153404",
            "https://youtu.be/IEEbUzffzrk",
            8.9f,
            "September 22, 1994",
            "USA",
            "Sitcom, Comedy",
            "10 seasons (22 minutes)",
            "Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc",
            "Ross Geller, Rachel Green, Monica Geller, Joey Tribbiani, Chandler Bing, and Phoebe Buffay are six twenty-somethings living in New York City. Over the course of 10 years and seasons, these friends go through life lessons, family, love, drama, friendship, and comedy.",
            "serial",
            true
        )
    )

    fun addRecords(){
        data.forEach {
            dao.addData(it)
        }
    }
}
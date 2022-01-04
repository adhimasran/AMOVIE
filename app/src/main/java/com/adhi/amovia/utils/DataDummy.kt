package com.adhi.amovia.utils

import com.adhi.amovia.data.Film

object DataDummy {

    fun generateDummyMovies(): List<Film> {
        val movies = ArrayList<Film>()

        movies.add(
            Film(
                "m1",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                "Spider-Man: No Way Home",
                "Dec 15, 2021",
                8.4F,
                "2h 28m",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man."
            )
        )
        movies.add(
            Film(
                "m2",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
                "The Matrix Resurrections",
                "Dec 16, 2021",
                7.2F,
                "2h 28m",
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix."
            )
        )
        movies.add(
            Film(
                "m3",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/sR3iV0Jt080jgvPBtJhs3Tta1y9.jpg",
                "Resident Evil: Welcome to Raccoon City",
                "Nov 24, 2021",
                6.2F,
                "1h 47m",
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night."
            )
        )
        movies.add(
            Film(
                "m4",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                "Ecanto",
                "Nov 24, 2021",
                7.8F,
                "1h 42m",
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope."
            )
        )
        movies.add(
            Film(
                "m5",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                "Venom: Let There Be Carnage",
                "Sep 30, 2021",
                7.2F,
                "1h 37m",
                "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady."
            )
        )
        movies.add(
            Film(
                "m6",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/lAXONuqg41NwUMuzMiFvicDET9Y.jpg",
                "Red Notice",
                "Nov 04, 2021",
                6.8F,
                "1h 57m",
                "An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen."
            )
        )
        movies.add(
            Film(
                "m7",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                "Shang-Chi and the Legend of the Ten Rings",
                "Sep 01, 2021",
                7.8F,
                "2h 12m",
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization."
            )
        )
        movies.add(
            Film(
                "m8",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/30ULVKdjBcQTsj2aOSThXXZNSxF.jpg",
                "Clifford the Big Red Dog",
                "Nov 10, 2021",
                7.4F,
                "1h 37m",
                "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love."
            )
        )
        movies.add(
            Film(
                "m9",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                "Sing 2",
                "Dec 01, 2021",
                7.6F,
                "1h 50m",
                "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage."
            )
        )
        movies.add(
            Film(
                "m10",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg",
                "Eternals",
                "Nov 03, 2021",
                7.1F,
                "2h 37m",
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants."
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<Film> {
        val shows = ArrayList<Film>()

        shows.add(
            Film(
                "t1",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
                "Hawkeye",
                "Nov 24, 2021",
                8.5F,
                "50m",
                "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit."
            )
        )

        shows.add(
            Film(
                "t2",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg",
                "The Wheel of Time",
                "Nov 18, 2021",
                8F,
                "56m",
                "Follow Moiraine, a member of the shadowy and influential all-female organization called the “Aes Sedai” as she embarks on a dangerous, world-spanning journey with five young men and women. Moiraine believes one of them might be the reincarnation of an incredibly powerful individual, whom prophecies say will either save humanity or destroy it."
            )
        )
        shows.add(
            Film(
                "t3",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/iF8ai2QLNiHV4anwY1TuSGZXqfN.jpg",
                "Chucky",
                "Oct 12, 2021",
                7.9F,
                "46m",
                "After a vintage Chucky doll turns up at a suburban yard sale, an idyllic American town is thrown into chaos as a series of horrifying murders begin to expose the town’s hypocrisies and secrets. Meanwhile, the arrival of enemies — and allies — from Chucky’s past threatens to expose the truth behind the killings, as well as the demon doll’s untold origins."
            )
        )
        shows.add(
            Film(
                "t4",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/7vjaCdMw15FEbXyLQTVa04URsPm.jpg",
                "The Witcher",
                "Dec 20, 2019",
                8.2F,
                "1h",
                "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts."
            )
        )
        shows.add(
            Film(
                "t5",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg",
                "Squid Game",
                "Sep 17, 2021",
                7.8F,
                "54m",
                "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor."
            )
        )
        shows.add(
            Film(
                "t6",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "Oct 07, 2014",
                7.8F,
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
            )
        )
        shows.add(
            Film(
                "t7",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/iqWCUwLcjkVgtpsDLs8xx8kscg6.jpg",
                "Yellowstone",
                "Jun 20, 2018",
                8F,
                "42m",
                "Follow the violent world of the Dutton family, who controls the largest contiguous ranch in the United States. Led by their patriarch John Dutton, the family defends their property against constant attack by land developers, an Indian reservation, and America’s first National Park."
            )
        )
        shows.add(
            Film(
                "t8",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/ekZobS8isE6mA53RAiGDG93hBxL.jpg",
                "Lucifer",
                "Jan 25, 2016",
                8.5F,
                "45m",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape."
            )
        )
        shows.add(
            Film(
                "t9",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/tEHHfzqHnfNJUp4L30wQeYl2xRo.jpg",
                "Harry Potter: Hogwarts Tournament of Houses",
                "Nov 28, 2021",
                7.9F,
                "44m",
                "Wizarding World fans put their Harry Potter knowledge to the test for the ultimate honor to be named House Cup champion."
            )
        )
        shows.add(
            Film(
                "t10",
                "https://www.themoviedb.org/t/p/w440_and_h660_face/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg",
                "Arcane",
                "Nov 06, 2021",
                9.1F,
                "42m",
                "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war between magic technologies and clashing convictions."
            )
        )

        return shows
    }
}
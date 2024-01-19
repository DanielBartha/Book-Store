package Proxy;

import java.util.ArrayList;
import java.util.List;

import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBookFactory;
import Factory.NonFictionBookFactory;

public class BookBasedOnAgeProxy {
        private int age;

        private Object[][] fantasyBooksInfo = {
                        { "The Lord of the Rings", "J.R.R Tolkien", 60,
                                        "The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore." },
                        { "Wolf Hall", "Hilary Mantel", 50,
                                        "Thomas Cromwell proves he is an ambitious man by becoming the chief advisor to King Henry VII." },
                        { "The Great Gatsby", "F. Scott Fitzgerald", 64,
                                        "Millionaire Jay Gatsby longs to be with the woman he loves, even though she’s married to someone else." },
                        { "Moby Dick", "Herman Melville", 35,
                                        "Ishmael, a sailor, joins the crew of a whaling ship and sets sail under the direction of a captain who is obsessed with killing the famous whale, Moby Dick." },
                        { "One Flew Over the Cuckoo’s", "Ken Kesey", 50,
                                        "Chief Bromden narrates the story about how a new patient at the Oregon State mental hospital challenges the powers which aim to keep the patients imprisoned." },
                        { "Catch-22", "Joseph Heller", 60,
                                        "Stationed in the Mediterranean Sea toward the end of World War II, Yossarian sees no escape from the enemy or from the army he’s a part of." },
        };

        private Object[][] matureFictionBooksInfo = {
                        { "American Psycho", "Bret Easton Ellis", 55,
                                        "Patrick Bateman appears to have the perfect life, but under the surface lurks a psychopath with a lesson for all of us." },
                        { "The Road", "Cormac McCarthy", 40,
                                        "A father and son walk through a post-apocalyptic America trying to survive." },
                        { "To Kill a Mockingbird", "Harper Lee", 62,
                                        "Scout Finch narrates the story of how her father defended a black man in a case where he was falsely accused of raping a white girl." },
                        { "Nineteen Eighty-Four", "George Orwell", 70,
                                        "In a dystopian society where Big Brother watches everyone, Winston Smith attempts to rebel against the Party in the name of liberty and truth." },
        };

        private Object[][] nonFictionBooksInfo = {
                        { "Charles III: New King. New Court. The Inside Story.", "Robert Hardman", 38,
                                        "A superb, fascinating account of the new King, his court and the first year of his reign. Elegantly written by the most authoritative of royal historians writing today, it is deeply researched, impeccably sourced and filled with scoops and new details. This is the definitive book" },
                        { "The Green Budget Guide", "Nancy Birtwhistle", 33,
                                        "How can you remove even the toughest stains? How can you make the best use of your microwave and keep meals healthy and tasty? How can you remove mould safely? Sunday Times bestselling author Great British Bake Off winner Nancy Birtwhistle is here to answer all of these questions and more, featuring 101 thoughtful, cheap and time-saving tips and tricks on how to run a budget home all while protecting the environment." },
                        { "The Art of Productivity", "James Clear", 25,
                                        "In this insightful guide, bestselling author James Clear shares practical strategies and habits to enhance productivity and achieve long-term success. Drawing on scientific research and real-world examples, Clear provides 101 actionable tips to help individuals and businesses optimize their workflow and achieve their goals efficiently."
                        },
                        { "Mindfulness at Work", "Ellen Langer", 30,
                                        "Renowned psychologist Ellen Langer presents a groundbreaking approach to mindfulness in the workplace. Packed with 33 years of research, \"Mindfulness at Work\" offers practical techniques for staying present, fostering creativity, and cultivating a positive work environment. Langer's evidence-based insights provide valuable tools for individuals seeking to thrive in their professional lives." },
                        { "Financial Freedom Blueprint", "Tony Robbins", 40,
                                        "Tony Robbins, the world-renowned life coach and financial expert, unveils his comprehensive guide to achieving financial freedom. In this book priced at $40, Robbins distills decades of experience into 101 actionable steps, offering readers a roadmap to financial independence. Learn proven strategies for wealth creation, investment, and mastering the psychology of money in this essential guide." },
        };

        private Object[][] matureNonFictionBooksInfo = {
                        { "The Power of Vulnerability", "Brené Brown", 28,
                                        "Renowned researcher and storyteller Brené Brown delves into the transformative impact of embracing vulnerability. Priced at $28, \"The Power of Vulnerability\" explores the connection between vulnerability, courage, and wholehearted living. Brown's insights provide a guide for mature readers seeking authentic connections and personal growth." },
                        { "Atomic Habits: Breakthroughs in Personal Development", "James Clear", 32,
                                        "James Clear, a leading expert in habit formation, presents a compelling exploration of atomic habits—tiny changes that lead to remarkable results. Priced at $32, this book provides actionable strategies for mature audiences to break bad habits, build good ones, and master the tiny behaviors that lead to remarkable outcomes." },
                        { "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 36,
                                        "In this thought-provoking narrative, historian Yuval Noah Harari takes mature readers on a journey through the history of humankind. Priced at $36, \"Sapiens\" offers a captivating exploration of how Homo sapiens have shaped the world and raises profound questions about the future of our species." },
                        { "Educated: A Memoir", "Tara Westover", 27,
                                        "Tara Westover's memoir, priced at $27, recounts her journey from a survivalist family in rural Idaho to earning a PhD from Cambridge University. \"Educated\" is a compelling story of resilience, self-discovery, and the pursuit of knowledge, making it a must-read for mature audiences." },
                        { "The Body Keeps the Score: Brain, Mind, and Body in the Healing of Trauma",
                                        "Bessel van der Kolk", 40,
                                        "Dr. Bessel van der Kolk, a leading expert on trauma, explores the profound impact of traumatic experiences on the body and mind. Priced at $40, \"The Body Keeps the Score\" offers mature readers valuable insights into the healing process and the ways in which trauma can be addressed for lasting well-being." },
        };
        private List<Book> bookList = new ArrayList<>();
        private FictionBookFactory fictionBookFactory = new FictionBookFactory();
        private NonFictionBookFactory nonFictionBookFactory = new NonFictionBookFactory();

        public void setBooksBasedOnAge() {
                for (Object[] fictionBook : fantasyBooksInfo) {
                        this.bookList.add(this.fictionBookFactory.createBook(fictionBook));
                }
                for (Object[] nonFinctionBook : nonFictionBooksInfo) {
                        this.bookList.add(this.nonFictionBookFactory.createBook(nonFinctionBook));
                }
                if (age >= 18) {
                        for (Object[] fictionBook : matureFictionBooksInfo) {
                                this.bookList.add(this.fictionBookFactory.createBook(fictionBook));
                        }
                        for (Object[] nonFictionBook : matureNonFictionBooksInfo) {
                                this.bookList.add(this.nonFictionBookFactory.createBook(nonFictionBook));
                        }
                }
        }

        public String getInfo() {
                if (this.age >= 18)
                        return "You are over 18, you have access to all the books.";
                return "You are underaged, you have limited access to the books.";
        }

        public List<Book> getListOfBooks() {
                return this.bookList;
        }

        public void setAge(int age) {
                this.age = age;
        }

}

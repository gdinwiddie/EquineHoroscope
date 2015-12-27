# EquineHoroscope

I think I got this project idea from a software development book back in the mid 1980s, but I haven't been able to identify the book. Perhaps it was a dream. I've built parts of this system a couple times, planning to use it for demos and classes. It goes out of date, however. The tools change, libraries change, computing environments change. It's very, very hard to keep a program in compilable condition without frequent attention over the years. So, I'm starting over and putting it in public this time.

## The "Requirements"

The core of the idea is to provide horoscopes for racehorses on race day. This gives the savvy bettor a leg up on the competition, allowing them to do better than the track odds predict. That's true, if the horoscopes work. Of course, no prediction mechanism works all the time. So if the horoscope doesn't pan out, it's just your bad luck. Try again, and I'm sure you'll win back your money. Horoscopes and horse-racing seem a natural combination.

Back in the 1980s it seemed like a novel idea to me. Now, a Google search shows me that people are in that very business. No matter. I will persevere.

I started with an example map (See https://cucumber.io/blog/2015/12/08/example-mapping-introduction) of the initial features.

![Photo of the example map](docs/ExampleMap.jpg "Equine Horoscope Example Map")

The **yellow** cards are Features. The **blue** cards are business rules. The **green** cards are scenarios I'll want to consider. And the **red** cards are questions.

## The Code

The code base started with [a fork](https://github.com/gdinwiddie/cucumber-java-skeleton/tree/eclipse-ready) of https://github.com/cucumber/cucumber-java-skeleton modified for working in Eclipse.

Right now, it has one passing scenario. This scenario calls an instance of CrystalBall and ensures that the returned horoscope is not blank. That's not much of a test, but it is enough to force a rudimentary API into existence.

What can force an actual implementation?

We could...

1. **Triangulate using scenarios** If we implement the next scenario, *Different horse, same day,* then we would expect a different horoscope. Since we're currently returning the same string all the time, it will force us to do something a little more clever, such as generate an actual horoscope.

2. **Dig deeper with unit tests** 

This also gives us two possibilities. We could...

1. Use an **interaction-based unit test**, where we specify the interactions with a collaborating object (using a mock). This is often called the *Mockist or London style of unit testing.*

2. Use a **state-based unit test**, where we interact with a collaborating object and then check the state. This is often called the *Classical or Detroit school of unit testing.*

See Martin Fowler's article, [Mocks Aren't Stubs](http://martinfowler.com/articles/mocksArentStubs.html) for a quick overview on the topic.


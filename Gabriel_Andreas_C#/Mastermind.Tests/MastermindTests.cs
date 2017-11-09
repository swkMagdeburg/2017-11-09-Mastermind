using System.Linq;
using NUnit.Framework;

namespace Mastermind.Tests
{
    [TestFixture]
    public class EvaluateShould
    {
        private MastermindEvaluation _sut;

        // Annahmen: 
        // keine doppelten Farben

        [SetUp]
        public void Setup()
        {
            _sut = new MastermindEvaluation();
        }

        [Test]
        public void DetectNoCatch()
        {
            var secret = new PinColors[] { };
            var guess = new PinColors[] { };

            EvaluationResult actual = _sut.Evaluate(secret, guess);

            Assert.Multiple(() =>
            {
                Assert.That(actual.CorrrectColorCount, Is.EqualTo(0));
                Assert.That(actual.CorrectPostionCount, Is.EqualTo(0));
            });
        }

        [Test]
        public void DetectOneCorrectColorCount()
        {
            var secret = new[] {PinColors.Blue, PinColors.Green};
            var guess = new[] {PinColors.Green, PinColors.Purple};

            var actual = _sut.Evaluate(secret, guess);

            Assert.Multiple(() =>
            {
                Assert.That(actual.CorrectPostionCount, Is.EqualTo(0));
                Assert.That(actual.CorrrectColorCount, Is.EqualTo(1));
            });
        }

        [Test]
        public void DetectOneCorrectColorCountWith4Pins()
        {
            var secret = new[] { PinColors.Blue, PinColors.Green, PinColors.Red, PinColors.Yellow };
            var guess = new[] { PinColors.Green, PinColors.Purple, PinColors.Pink, PinColors.Red };

            var actual = _sut.Evaluate(secret, guess);

            Assert.Multiple(() =>
            {
                Assert.That(actual.CorrectPostionCount, Is.EqualTo(0));
                Assert.That(actual.CorrrectColorCount, Is.EqualTo(2));
            });
        }
    }

    public class MastermindEvaluation
    {
        public EvaluationResult Evaluate(PinColors[] secret, PinColors[] guess)
        {
            EvaluationResult result = new EvaluationResult(0, 0);

            foreach (var guessColors in guess)
            {
                if (secret.Contains(guessColors))
                {
                    result.CorrrectColorCount++;
                }
            }

            return result;
        }
    }
}
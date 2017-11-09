namespace Mastermind.Tests
{
    public class EvaluationResult
    {
        public EvaluationResult(int corrrectColorCount, int correctPostionCount)
        {
            CorrrectColorCount = corrrectColorCount;
            CorrectPostionCount = correctPostionCount;
        }

        public int CorrrectColorCount { get; set; }
        public int CorrectPostionCount { get; set; }
    }
}
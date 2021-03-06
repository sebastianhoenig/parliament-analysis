/**
 * API requests for Token for all speeches.
 * @author vanessa
 *
 */

function getAllToken() {
  $.ajax({
    url: "http://localhost:4567/token",
    method: "GET",
    dataType: "json",
    success: function (data) {
      var allToken = [];
      var tokenCount = [];

      for (let i = 0; i < data.result.length; i++) {
        if (data.result[i].count > 100000) {
          allToken.push(data.result[i].token);
          tokenCount.push(data.result[i].count);
        }
      }

      var colorList = [];
      for (let j = 0; j < allToken.length; j++) {
        colorList.push("#1cc88a");
      }

      createLineChart(allToken, tokenCount);
    },
    error: function () {
      console.log("Geht nicht... :");
    },
  });
}

/**
 * API requests for Sentiment by speaker.
 * modified by Ben, Sebastian
 * @param id
 * @param tokenID
 * @param beginDate
 * @param endDate
 */
function getTokenBySpeaker(id, tokenID, beginDate = "2017-10-20",endDate = "2022-02-11") {
  $.ajax({
    url: "http://localhost:4567/token?speakerID=" + id + "&beginDate=" + beginDate + "&endDate=" + endDate,
    method: "GET",
    dataType: "json",
    success: function (data) {
      var allToken = [];
      var tokenCount = [];

      for (let i = 0; i < data.result.length; i++) {
        if (data.result[i].count > 100) {
          allToken.push(data.result[i].token);
          tokenCount.push(data.result[i].count);
        }
      }

      createLineChartPerson(allToken, tokenCount, tokenID);
    },
    error: function () {
      console.log("Geht nicht... :");
    },
  });
}

/**
 * API requests for Sentiment by party.
 * modified by Ben, Sebastian
 * @param party
 * @param tokenID
 * @param beginDate
 * @param endDate
 */
function getTokenByParty(party, tokenID, beginDate = "2017-10-20",endDate = "2022-02-11") {
  $.ajax({
    url: "http://localhost:4567/token?party=" + party + "&beginDate=" + beginDate + "&endDate=" + endDate,
    method: "GET",
    dataType: "json",
    success: function (data) {
      var allToken = [];
      var tokenCount = [];

      for (let i = 0; i < data.result.length; i++) {
        if (data.result[i].count > 5000) {
          allToken.push(data.result[i].token);
          tokenCount.push(data.result[i].count);
        }
      }

      createLineChartPerson(allToken, tokenCount, tokenID);
    },
    error: function () {
      console.log("Geht nicht... :");
    },
  });
}

/**
 * creates line chart with flexible element id
 * modified by Sebastian
 * @param labelsInput
 * @param dataInput
 * @param tokenID
 */
function createLineChartPerson(labelsInput, dataInput, tokenID) {
  var ctx = document.getElementById(tokenID);
  var myBarChart = new Chart(ctx, {
    type: "line",
    data: {
      labels: labelsInput,
      datasets: [
        {
          fill: false,
          data: dataInput,
          borderColor: "#36b9cc",
          pointBorderColor: "#36b9cc",
        },
      ],
    },
    options: {
      plugins: {
        legend: false, // Hide legend
      },
      scales: {
        x: {
          gridLines: {
            color: "rgba(0, 0, 0, 0)",
          },
        },
        y: {
          gridLines: {
            color: "rgba(0, 0, 0, 0)",
          },
          ticks: {
            beginAtZero: true,
          },
        },
      },
    },
  });
}

/**
 * creates line chart for all token
 */
function createLineChart(labelsInput, dataInput) {
  var ctx = document.getElementById("myLineChartAllToken");
  var myBarChart = new Chart(ctx, {
    type: "line",
    data: {
      labels: labelsInput,
      datasets: [
        {
          fill: false,
          data: dataInput,
          borderColor: "#36b9cc",
          pointBorderColor: "#36b9cc",
        },
      ],
    },
    options: {
      plugins: {
        legend: false, // Hide legend
      },
      scales: {
        x: {
          gridLines: {
            color: "rgba(0, 0, 0, 0)",
          },
        },
        y: {
          gridLines: {
            color: "rgba(0, 0, 0, 0)",
          },
          ticks: {
            beginAtZero: true,
          },
        },
      },
    },
  });
}

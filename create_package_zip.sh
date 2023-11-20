echo "Cleaning the existing repo and zip files"
rm -rf autotrade
rm -rf sample-client
rm  -f autotrade.zip
echo "Cloning the repo"
echo "Enter bitbucket username"
read user
git clone https://$user@bitbucket.etrade.com/scm/api/sample-client.git -b integration autotrade
echo "Removing unnecessary files under the repo"
rm -rf  autotrade/EtradePythonClient
rm -rf  autotrade/README.md
rm -rf  autotrade/.git
echo "Starting the zip process"
cd autotrade
mv auto-etrade autotrade
rm -rf autotrade/.git
zip -r autotrade.zip autotrade
echo "autotrade.zip created...."
echo "Cleaing up the temporary files"
rm -rf ../zip
mkdir ../zip
cp autotrade.zip ../zip
cd ..
rm -rf autotrade
